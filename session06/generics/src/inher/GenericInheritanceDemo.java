package inher;

public class GenericInheritanceDemo {

    public static void main(String[] args) {
      GenInheritance   classChildGenInheritance=new GenInheritance<>();
      //GenInheritance<NoParent>   classChildGenInheritance2=new GenInheritance<NoParent>();
        GenInheritance<ClassParent>   parentGenInheritance=new GenInheritance<>();

    }
}
