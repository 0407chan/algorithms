function solution(numbers, target) {
  var answer = 0

  getAnswer(0, 0)
  function getAnswer(x, value) {
    if (x < numbers.length) {
      getAnswer(x + 1, value + numbers[x])
      getAnswer(x + 1, value - numbers[x])
    } else {
      if (value === target) {
        answer++
      }
    }
  }
  return answer
}

const numbers = [1, 1, 1, 1, 1]
const target = 3

console.log(solution(numbers, target))
