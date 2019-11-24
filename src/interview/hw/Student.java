package interview.hw;

public class Student implements Comparable<Student> {

    int score;
    int num;

    public Student(int score,int num) {
        this.score = score;
        this.num = num;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score != o.score){
            return this.score - o.score;
        }
        else {
            return this.num - o.num;
        }
    }
}
