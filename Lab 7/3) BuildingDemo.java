/*
Create a Building class with two subclasses namely, House and School. The Building class contains fields for square footage and stories. 
The House class contains additional fields for number of bedrooms and baths. 
The School class contains additional fields for number of classrooms and grade level (for example, elementary or junior high). 
All the classes contain appropriate overloaded constructors and methods to display the details. In a separate class that contains main(), demonstrate the working of this hierarchy.
*/
class Building {
    double squareFootage;
    int stories;

    public Building(double squareFootage, int stories) {
        this.squareFootage = squareFootage;
        this.stories = stories;
    }

    void display() {
        System.out.println("Square Footage: " + squareFootage);
        System.out.println("Stories: " + stories);
    }
}

class House extends Building {
    int bedrooms;
    int baths;

    public House(double squareFootage, int stories, int bedrooms, int baths) {
        super(squareFootage, stories);
        this.bedrooms = bedrooms;
        this.baths = baths;
    }

    void display() {
        super.display();
        System.out.println("Bedrooms: " + bedrooms);
        System.out.println("Baths: " + baths);
    }
}

class School extends Building {
    int classrooms;
    String gradeLevel;

    public School(double squareFootage, int stories, int classrooms, String gradeLevel) {
        super(squareFootage, stories);
        this.classrooms = classrooms;
        this.gradeLevel = gradeLevel;
    }

    void display() {
        super.display();
        System.out.println("Classrooms: " + classrooms);
        System.out.println("Grade Level: " + gradeLevel);
    }
}

class BuildingDemo {
    public static void main(String args[]) {
        House house = new House(2000, 2, 4, 3);
        School school = new School(5000, 3, 20, "High School");

        System.out.println("\nHouse Details:");
        house.display();

        System.out.println("\nSchool Details:");
        school.display();
    }
}
