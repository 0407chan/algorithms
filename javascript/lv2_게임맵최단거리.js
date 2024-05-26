function solution(maps) {
  const n = maps[0].length - 1
  const m = maps.length - 1
  const queue = [[0, 0, 1]]
  while (queue.length) {
    const [x, y, count] = queue.shift()
    if (x == n && y == m) return count //bfs라서 처음 도착한게 최단거리
    if (!maps[y][x]) continue
    maps[y][x] = false

    if (x - 1 >= 0 && maps[y][x - 1]) queue.push([x - 1, y, count + 1])
    if (x + 1 <= n && maps[y][x + 1]) queue.push([x + 1, y, count + 1])
    if (y - 1 >= 0 && maps[y - 1][x]) queue.push([x, y - 1, count + 1])
    if (y + 1 <= m && maps[y + 1][x]) queue.push([x, y + 1, count + 1])
  }

  return -1
}

const maps = [
  [1, 0, 1, 1, 1],
  [1, 0, 1, 1, 1],
  [1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1]
]
console.log(solution(maps)) // 11
