package programs.test;

import java.util.concurrent.Callable;

interface Bird {
    Egg lay();
}

class Chicken implements Bird {

    public Chicken() {
    }

    public Egg lay() {
        return new Egg(new Callable<Bird>() {
            @Override
            public Chicken call() throws Exception {
                return new Chicken();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
        Egg egg1 = chicken.lay();
        egg1.hatch();
        egg1.hatch();

    }
}

class Egg
{
    Callable<Bird> createBird;
    public Egg(Callable<Bird> createBird) {
        this.createBird = createBird;
    }

    public Bird hatch() throws Exception {
        if (createBird == null)
            throw new IllegalStateException();
        try {
            return createBird.call();
        } finally {
            createBird = null;
        }
    }
}
