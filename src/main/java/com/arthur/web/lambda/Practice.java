package com.arthur.web.lambda;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * Created by wangtao on 2017/10/20.
 */
public class Practice {

	public static void main(String[] args){
		List<Apple> apples = new ArrayList<>();

		for(int i = 0; i < 10; i++ ){
			Apple apple = new Apple();
			if( i % 3 == 0){
				apple.setColor("green");
				apple.setWeight(100 + (i*10));
			}

			apples.add(apple);

		}
		Pp<Apple> hasGreenApple = (Apple::isGreen);

		Pp<Apple> hasRedApple = (Apple a) -> a.isRed();
		List<Apple> redApples = filter(apples, hasRedApple);
		System.out.println("Red apples has :" + redApples.size());
		List<Apple> greenApples = filter(apples,  hasGreenApple);
		System.out.println("Green apples has :" + greenApples.size());

		apples.stream()
			.filter(Apple::isGreen)
			.map(Apple::getColor)
			.forEach((String a) -> System.out.println("apple color is " + a));

		apples.stream()
			.filter((Apple a) -> a.getWeight() > 100 )
			.forEach((Apple a) ->
						 System.out.println("apple color is " + a.getColor()
											+ " and weight is " + a.getWeight() + " g."));
		Integer sum = apples.stream()
			  .filter((Apple a) -> a.getWeight() > 100 )
			  .map(Apple::getWeight)
			  .reduce(0, Integer::sum);
		System.out.println("weight than 100 amount is " + sum);

		Optional<Integer> max = apples.stream()
									  .map(Apple::getWeight)
									  .reduce(Integer::max);
		System.out.println("havest apple weight is " + max);

	}


	private static class Apple {
		private String color;
		private Integer weight;
		public  Apple(){
			color = "red";
			weight = 100;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public boolean isRed() {
			return "red".equals(color) ;
		}

		public boolean isGreen() {
			return "green".equals(color);
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}
	}

	public static <T> List<T> filter(List<T> list, Pp<T> pp){
		List<T> results = new ArrayList<>();
		for(T t : list){
			if(pp.test(t)){
				results.add(t) ;
			}
		}
		return results;
	}

	@FunctionalInterface
	private interface Pp<T>{
		boolean test(T t);
	}

}


