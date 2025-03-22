package Assignment;

class Genre {
    public static final int UNDEFINED = 0;
    public static final int POP = 1;
    public static final int ROCK = 2;
    public static final int HIP_HOP = 3;
    public static final int RNB = 4;
    public static final int JAZZ = 5;
    public static final int INSTRUMENTALS = 6;
    public static final int CLOWNCORE = 7;

    public static String getGenreName(int genre) {
        switch (genre) {
            case POP:
                return "Pop";
            case ROCK:
                return "Rock";
            case HIP_HOP:
                return "Hip Hop";
            case RNB:
                return "RnB";
            case JAZZ:
                return "Jazz";
            case INSTRUMENTALS:
                return "Instrumentals";
            case CLOWNCORE:
                return "Clowncore";
            default:
                return "Undefined";
        }
    }
}

class Album {
    private String name;
    private String coverURL;

    public Album(String name, String coverURL) {
        this.name = name;
        this.coverURL = coverURL;
    }

    public String getName() {
        return name;
    }
}

class Artist {
    private String name;
    private String alias;
    private String imageURL;

    public Artist(String name, String alias, String imageURL) {
        this.name = name;
        this.alias = alias;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }
}

public class Song {
    private String id;
    private String title;
    private String releaseYear;
    private String musicFileURL;
    private int genre = Genre.UNDEFINED;
    private Album album;
    private Artist artist;

    public Song(String id, String title, String releaseYear, String musicFileURL) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.musicFileURL = musicFileURL;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public void printInfo(int detailLevel) {
        System.out.println("Song Title: " + title);
        System.out.println("Release Year: " + releaseYear);
        if (genre != Genre.UNDEFINED) {
            System.out.println("Genre: " + Genre.getGenreName(genre));
        }

        if (detailLevel >= 1 && artist != null) {
            System.out.println("Artist Name: " + artist.getName());
            if (!artist.getAlias().isEmpty()) {
                System.out.println("Also known as: " + artist.getAlias());
            }
        }

        if (detailLevel >= 2 && album != null) {
            System.out.println("Album Title: " + album.getName());
        }
    }
}
