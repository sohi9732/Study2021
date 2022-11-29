package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gold5_17471_게리맨더링 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[] population;
	static ArrayList<Integer>[] arr;
	static boolean[] isSelected;
	static boolean possible;
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		arr = new ArrayList[N];
		population = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> arrList = new ArrayList<>();
			st = new StringTokenizer(in.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				arrList.add(Integer.parseInt(st.nextToken())-1);
			}
			arr[i] = arrList;
		}
		
		generateSubset(0); //부분 집합
		
		if(possible) System.out.println(min);
		else System.out.println(-1);
	}

	private static void generateSubset(int cnt) {
		if(cnt == N) {
			if(isPossible() && isNotAll()) { //두 선거구로 나눌 수 있는 경우
				//경우 찍어보기
				//print();
				
				//두 선거구의 인구 수 차이 계산
				int a = 0, b = 0;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) a += population[i];
					else b += population[i];					
				}
				int diff = Math.abs(a-b);
				min = Math.min(min, diff);
				possible = true;
			}
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}

	private static boolean isPossible() {
		isVisited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {
				isVisited[i] = true;
				dfs(i, true);
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			if(!isSelected[i]) {
				isVisited[i] = true;
				dfs(i, false);
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(!isVisited[i]) return false;
		}
		return true;
	}
	
	private static void dfs(int cnt, boolean flag) {
		for (int i = 0; i < arr[cnt].size(); i++) {
			if(flag == isSelected[arr[cnt].get(i)] && !isVisited[arr[cnt].get(i)]) {
				isVisited[arr[cnt].get(i)] = true;
				dfs(arr[cnt].get(i), flag);
			}
		}
	}
	
	private static boolean isNotAll() {
		int tCnt = 0, fCnt = 0;
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) tCnt++;
			else fCnt++;
		}
		
		//부분 집합에서 모두 선택 경우, 모두 비선택 경우 제외
		if(tCnt == 0 || fCnt == 0) return false;
		return true;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) System.out.print(i + " ");
		}
		System.out.print("/ ");
		for (int i = 0; i < N; i++) {
			if(!isSelected[i]) System.out.print(i + " ");
		}
		System.out.println();
	}

}
