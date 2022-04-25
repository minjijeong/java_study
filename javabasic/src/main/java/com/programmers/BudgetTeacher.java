package com.programmers;

import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/2512
 *
 * 국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것입니다.
 * 국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있습니다.
 * 그래서 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정합니다.
 *
 * 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정합니다.
 * 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정합니다.
 *    상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정합니다.
 *
 * 예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150일 때,
 * 상한액을 127로 잡으면 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고
 * 그 합이 484로 가능한 최대가 됩니다.
 *
 * 각 지방에서 요청하는 예산이 담긴 배열 budgets과 총 예산 M이 매개변수로 주어질 때,
 * 위의 조건을 모두 만족하는 상한액을 return 하도록 solution 함수를 작성해주세요.
 *
 * ## 제한 사항
 * 지방의 수는 3 이상 100,000 이하인 자연수입니다.
 * 각 지방에서 요청하는 예산은 1 이상 100,000 이하인 자연수입니다.
 * 총 예산은 지방의 수 이상 1,000,000,000 이하인 자연수입니다.
 */
public class BudgetTeacher {
    public static int solution(int[] budgets, int M) {
        int answer = 0;

        int min = 0;
        int max = IntStream.of(budgets).max().orElse(0); // Optional orElse로 값이 없으면 0으로 표현
        /*
        for(int b : budgets){
            if( b > max) max = b;
        }
         */

        while(min <= max){
            // Stream을 사용할때, function 안에서 사용되는 변수는 가변변수를 사용하면 안되서 final로 변환
            final int mid = (min + max) / 2; // 예산의 상한액으로 가정
            long sum = IntStream.of(budgets)
                    .map(b -> Math.min(b, mid))
                    .sum();
            /*
            for(int b : budgets){
                if(b> mid) sum += mid;
                else sum += b;
            }
            */

            if(sum <= M){
                min = mid + 1;
                answer = mid;
            } else{
              max = mid -1;
            }
        }

        return answer;
    }

    // [120, 110, 140, 150]	485	127
    public static void main(String[] args) {
        int[] arr = {120, 110, 140, 150};
        int M = 485;
        System.out.println(solution(arr, M));
    }
}
