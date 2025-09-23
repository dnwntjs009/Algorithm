import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, Map<Integer, Integer>> music = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            music.putIfAbsent(genres[i], new HashMap<>());
            music.get(genres[i]).put(i, plays[i]);

            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreList = new ArrayList(genreCnt.keySet());
        Collections.sort(genreList, (a, b) -> genreCnt.get(b) - genreCnt.get(a));
        
        for ( String genre : genreList ) {
            Map<Integer, Integer> map = music.get(genre);
            List<Integer> genreIdx = new ArrayList(map.keySet());
            
            Collections.sort(genreIdx, (a, b) -> map.get(b) - map.get(a));
            
            answer.add(genreIdx.get(0));
            if (genreIdx.size() > 1) answer.add(genreIdx.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}