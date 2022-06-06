import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Weather} from "../interface/weather";


@Injectable({
  providedIn:"root"
})
export class weatherService{
  private readonly API_URL = "https://api.openweathermap.org/data/2.5/weather?q=Turan,vn&APPID=7f04d3d0c6be2e335b4e4c7a6c8b1b60&units=metric";

  constructor(private _httpClient : HttpClient) {
  }

  getWeather(): Observable<Weather>{
    return this._httpClient.get<Weather>(this.API_URL);
  }
}
