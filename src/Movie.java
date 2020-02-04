
public class Movie {
	String title;
	String category;

	public Movie() {

	}

	public Movie(String t, String c) {
		title = t;
		category = c;
	}

	public Movie(String t, int c) {
		title = t;
		category = catList(c);
	}

	public void setTitle(String t) {
		title = t;
	}

	public void setCat(String c) {
		category = c;
	}

	public String getTitle() {
		return title;
	}

	public String getCat() {
		return category;
	}

	public String catList(int c) {
		switch (c) {
		case 1: {
			return "drama";
		}
		case 2: {
			return "comedy";
		}
		case 3: {
			return "scifi";
		}
		case 4: {
			return "horror";
		}
		case 5: {
			return "musical";
		}
		case 6: {
			return "animated";
		}
		case 7: {
			return "western";
		}
		case 8: {
			return "war";
		}
		default:
			return "No Such Genre Available";

		}
	}

}
