import {Component, OnInit} from '@angular/core';
import {weatherService} from "../services/weatherService";
import {Weather} from "../interface/weather";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  weather!: Weather;
  temp: number = 0;
  idIcon: string = "";

  constructor(private _weatherService: weatherService) {
  }

  ngOnInit(): void {
    this._weatherService.getWeather().subscribe((data) => {
      this.weather = data;
      console.log(data);
      this.temp = Math.floor(this.weather.main.temp)+1;
      this.idIcon = this.weather.weather[0].icon;
    })
  }

}
