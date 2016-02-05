package jai.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newSingleThreadExecutor();
		Callable task1 = new Callable1();
		Callable task2 = new Callable2();
		Callable task3 = new Callable3();

		for (int i = 0; i < 100; i++) {
			eService.submit(new Callable1(new Pojo1(System.currentTimeMillis()+"",new Random().nextInt())));
			eService.submit(task2);
			eService.submit(task3);
		}

	}
}

class Callable1 implements Callable {

	Callable1() {

	}

	Callable1(Pojo1 pojo) {

	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

class Callable2 implements Callable {

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

class Callable3 implements Callable {

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

class Pojo1 {
	String name;
	Integer id;
	String value;

	
	public Pojo1(String name, Integer id, String value) {
		super();
		this.name = name;
		this.id = id;
		this.value = value;
	}
	
	public Pojo1(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}


	public Pojo1() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}