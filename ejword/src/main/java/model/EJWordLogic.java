package model;

import java.util.Arrays;
import java.util.List;

import dao.WordDAO;

public class EJWordLogic {
	public void execute(EJWord ejw) {
		WordDAO dao = new WordDAO();
		int total = dao.getCount(ejw.getSearchWord(), ejw.getMode());
		System.out.println("ログ: logic: total:"+total);
		ejw.setTotal(total);
		List<Word> list = dao.getListBySearchWord(
				ejw.getSearchWord(),
				ejw.getMode(),
				ejw.getLimit(),
				(ejw.getPageNo()-1) * ejw.getLimit()
				);
		ejw.setList(list);
		if(total > ejw.getLimit()) {
			int pageCount = total % ejw.getLimit() == 0? total / ejw.getLimit() : total / ejw.getLimit() +1;
			System.out.println("ログ: logic:pagecount:"+pageCount);
			String[][] pager;
			if(pageCount < 20) {
				pager = new String[pageCount][];
				for(int i=0; i<pageCount; i++) {
					pager[i] = new String[] {ejw.getPageNo() == i+1? "active" : "", i+1+"", i+1+""};//要素３つの配列を作る ※ i+1+"":intから文字列に変換する
					System.out.println("ログ: logic pager [i]"+Arrays.toString(pager[i]));
				}
			}else {
				//このページの前に何ページ分リンクを設定するか(最大５件)
				int before = Math.min(ejw.getPageNo()-1, 5);
				System.out.println("ログ: logic before:"+before);
				int after = Math.min(pageCount-ejw.getPageNo(), 5);
				System.out.println("ログ: logic after:"+after);
				int len = 1 + before + 1 + after + 1;
				System.out.println("ログ: logic: len:"+len);
				pager = new String[len][];
				//先頭ページへのリンク{クラス名,リンク先ページ,表示文言}
				pager[0] = new String[] {ejw.getPageNo() == 1? "disabled":"", 1+"", "<<"};
				for(int i=1, page=ejw.getPageNo()-before; i<len-1; i++,page++) {
					pager[i]=new String[] {page==ejw.getPageNo()? "active" : "",page+"", page+""};
					/*for(int i=0, j=0; i<3;i++) {System.out.println(i+j);} このような書き方と同じ↑*/
					System.out.println("ログ: logic: pager[i]:"+Arrays.toString(pager[i]));
				}
				
				//末尾ページへのリンク
				pager[len-1] = new String[] {ejw.getPageNo()==pageCount? "disabled":"", pageCount+"",">>"};
				}
			ejw.setPager(pager);
				
				
		}
	}
}












