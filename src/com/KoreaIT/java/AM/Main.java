package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");;
		
		Scanner sc = new Scanner(System.in);
		
		// 몇 번째 글이 작성되었는지 글 번호
		int lastArticleId = 0;
		
		List<Article> articles = new ArrayList<>();
		
		while (true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();
			
			if (command.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			
			if (command.equals("system exit")) {
				break;
			}
			if (command.equals("article write")) {
				int id  = lastArticleId + 1;
				lastArticleId = id;
				System.out.println("제목 : \n");
				String title = sc.nextLine();
				System.out.println("내용 : \n");
				String body = sc.nextLine();
				
				Article article = new Article(id, title, body);
				articles.add(article);
				
				System.out.printf("%d번글이 생성되었습니다.\n", id);
			}
			
			else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.println("번호 | 제목");
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					System.out.printf("%d | %s\n", article.id, article.title);
				}
			} else if (command.startsWith("article detail ")) {
				
				String[] commandBits = command.split(" ");
				
				int id = Integer.parseInt(commandBits[2]);
				
				Article foundArticle = null;
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				System.out.printf("%d번 게시물은 존재합니다.\n", id);
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : 2022-12-12 12:12:12\n");
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);
				
			}else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}
		
		sc.close();
		
		System.out.println("==프로그램 끝==");
	}
}

class Article {
	int id;
	String title;
	String body;
	
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
