/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package comparisons;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {


    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("The Shawshank Redemption", 1994, List.of("Drama")),
                new Movie("A Beautiful Mind", 2001, List.of("Drama", "Biography")),
                new Movie("Avatar", 2009, List.of("Action", "Adventure", "Fantasy")),
                new Movie("Inception", 2010, List.of("Action", "Adventure", "Sci-Fi")),
                new Movie("Pulp Fiction", 1994, List.of("Crime", "Drama")),
                new Movie("Anchorman", 2004, List.of("Comedy"))
        );

        System.out.println("Movies year before sort");
        movies.stream().forEach(movie -> {
            System.out.print(movie.year+" ");});
        List<Movie> moviesSortedByYear= sortMoviesByYear(movies);

        System.out.println("\nMovies year After sort");
        sortMoviesByYear(movies).stream().forEach(movie -> {
            System.out.print(movie.year+" ");});


        System.out.println("\nMovies title before sort");
        movies.stream().forEach(movie -> {
            System.out.print(movie.title);});
        System.out.println("\nMovies title before sort");

        sortMoviesByTitleIgnoringPrefix(movies).stream().forEach(movie -> {
            System.out.print(movie.title+ " ");});



    }


    public static List<Movie> sortMoviesByYear(List<Movie> movies) {
        return movies.stream()
                .sorted((a, b) -> Integer.compare(a.getYear(), b.getYear()))
                .collect(Collectors.toList());
    }

    public static List<Movie> sortMoviesByTitleIgnoringPrefix(List<Movie> movies) {
        return movies.stream()
                .sorted((a, b) -> {

                    String titleA = a.getTitle().replaceAll("^(A|An|The) ", "");
                    String titleB = b.getTitle().replaceAll("^(A|An|The) ", "");
                    return titleA.compareTo(titleB);
                })
                .collect(Collectors.toList());
    }
}