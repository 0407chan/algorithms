const dx = [0, 1, 0, -1]
const dy = [1, 0, -1, 0]

function solution(maps) {
  let answer = Infinity
  const endX = maps.length - 1
  const endY = maps[0].length - 1

  const visitMap = JSON.parse(JSON.stringify(maps))
  visitMap.forEach((arr) => arr.fill(false))

  getAnswer(0, 0, 0, visitMap)
  function getAnswer(x, y, count, visit) {
    const newVisit = JSON.parse(JSON.stringify(visit))
    if (
      x < 0 ||
      y < 0 ||
      x > endX ||
      y > endY ||
      visit[x][y] ||
      maps[x][y] === 0
    ) {
      return
    }

    newVisit[x][y] = true

    if (x === endX && y === endY) {
      answer = Math.min(answer, count + 1)
      return
    }

    for (let i = 0; i < 4; i++) {
      const xx = dx[i]
      const yy = dy[i]
      getAnswer(x + xx, y + yy, count + 1, newVisit)
    }
  }

  return answer === Infinity ? -1 : answer
}

const maps = [
  [1, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
  [1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0],
  [1, 1, 1, 0, 1]
]
console.log(solution(maps)) // 11
