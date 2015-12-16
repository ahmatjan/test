package com.shenny.test.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

import com.shenny.test.dao.IPostDetailDao;
import com.shenny.test.model.PostDetail;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

/**
 * @ClassName: LuceneService
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年10月22日 上午10:46:47
 */

@Service
public class LuceneService implements ILuceneService {

	@Inject
	IPostDetailDao postDetailDao;

	Directory index;
	Analyzer analyzer;
	IndexWriter w;

	@PostConstruct
	void indexInit() {
		File dir = new File("D:/lucene/a.blog");
		boolean indexExists = dir.exists();
		try {
			index = FSDirectory.open(dir);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		analyzer = new PaodingAnalyzer();
		if (!indexExists) {
			openIndexWriter();
			List<PostDetail> list = postDetailDao.listAllPost();
			for (PostDetail post : list) {
				addIndex(post);
			}
			closeIndexWriter();
		}
	}

	void addDoc(IndexWriter w, String title, String isbn) throws IOException {
		Document doc = new Document();
		doc.add(new TextField("title", title, Field.Store.YES));

		// use a string field for isbn because we don't want it tokenized
		doc.add(new StringField("isbn", isbn, Field.Store.YES));
		w.addDocument(doc);
	}

	@Override
	public void addIndex(PostDetail post) {
		Document doc = new Document();
		doc.add(new TextField("id", String.valueOf(post.getId()), Field.Store.YES));
		doc.add(new TextField("title", post.getTitle() == null ? "" : post.getTitle(), Field.Store.YES));
		doc.add(new TextField("content", post.getContent() == null ? "" : post.getContent(), Field.Store.YES));
		try {
			w.addDocument(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<PostDetail> query(String query) {
		return query(query, "title");
	}

	@Override
	public List<PostDetail> query(String query, String fieldName) {

		if (index == null)
			indexInit();
		List<PostDetail> list = new ArrayList<PostDetail>();
		try {
			Query q = new QueryParser(Version.LUCENE_46, fieldName, analyzer).parse(query);

			int hitsPerPage = 10;
			IndexReader reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
			searcher.search(q, collector);
			ScoreDoc[] hits = collector.topDocs().scoreDocs;
			if (hits != null && hits.length > 0) {
				for (ScoreDoc doc : hits) {
					PostDetail post = new PostDetail();
					int docId = doc.doc;
					Document d = searcher.doc(docId);
					post.setId(Integer.valueOf(d.get("id")));
					post.setTitle(d.get("title"));
					post.setContent(d.get("content"));
					list.add(post);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void openIndexWriter() {
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46, analyzer);
		try {
			w = new IndexWriter(index, config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void closeIndexWriter() {
		try {
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (w != null)
				w = null;
		}

	}

}
