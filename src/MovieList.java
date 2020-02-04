import java.util.*;

/*
 * 
 * @ David Breitenbeck
 * 
 */

public class MovieList {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i <= 100; i++) {
			list.add(MovieIO.getMovie(i));
		}

		System.out.println("Select from the list of available film categories:");
		System.out.println("=================================================");
		ArrayList<String> titles = new ArrayList<String>();
		String[] genres = { "1. Drama", "2. Comedy", "3. Scifi", "4. Horror", "5. Musical", "6. Animated", "7. Western",
				"8. War" };

		for (String g : genres) {
			System.out.println(g);
		}

		Movie m = new Movie();
		do {
			System.out.println();
			int category = searchCatList(scanner);
			titles = listMovies(category, list);
			String cat = m.catList(category);
			Collections.sort(titles);
			System.out.println("There are " + titles.size() + " Films in the " + cat.toUpperCase() + " Category:");
			for (String t : titles) {
				System.out.println("-" + t);
			}

		} while (contd(scanner));

		System.out.println("Goodbye");
		scanner.close();

	}

	// Search by entering category String
	public static String searchCat(Scanner scan) {
		String cat = Validator.getString(scan, "Enter Category \n");
		return cat;
	}

	// Search by category number
	public static int searchCatList(Scanner scan) {
		int c = Validator.getInt(scan, "Enter the Number of the  Category You Are Interested In: \n", 1, 8);
		return c;
	}

	// Search by category number
	public static ArrayList<String> listMovies(int c, List<Movie> l) {
		String title = "No such movie";
		ArrayList<String> ts = new ArrayList<String>();
		for (Movie m : l) {
			String cat = m.catList(c);
			String genre = m.getCat();
			if (genre.equalsIgnoreCase(cat)) {
				title = m.getTitle();
				ts.add(title);
			}
		}
		if (ts.isEmpty()) {
			ts.add(title);
		}

		return ts;
	}

	// Search by entering category String
	public static ArrayList<String> showMovies(String c, List<Movie> l) {
		String title = "No such movie";
		ArrayList<String> ts = new ArrayList<String>();
		for (Movie m : l) {
			String cat = m.getCat();
			if (c.equalsIgnoreCase(cat)) {
				title = m.getTitle();
				ts.add(title);
			}
		}
		if (ts.isEmpty()) {
			ts.add(title);
		}

		return ts;
	}

	public static boolean contd(Scanner sc) {
		boolean c = true;
		String a = Validator.getStringMatchingRegex(sc, "Do you want to continue? y/n \n", "[yn]").toLowerCase();
		c = a.contentEquals("y");
		return c;
	}

}
