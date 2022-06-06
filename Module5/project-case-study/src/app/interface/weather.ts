export interface Weather {
  coord: { lon: string, lat: string },
  weather: [{ id: number, main: string, description: string, icon: string }],
  base: string,
  main: { temp: number, feels_like: string, temp_min: number, temp_max: number, pressure: number, humidity: number },
  visibility: number,
  wind: { speed: number, deg: number },
  cool: { all: number },
  dt: number,
  sys: { type: number, id: number, country: string, sunrise: number, sunset: number },
  timezone: number,
  id: number,
  name: string,
  cod: number
}
