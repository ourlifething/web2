package model;

import java.util.List;

public class PostCommentLogic {
	public void execute(Movie movieInfo, List<Movie> movie) {
		movie.add(movieInfo);
	}

}
