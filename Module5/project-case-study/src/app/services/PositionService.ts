import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Position} from "../interface/position";

@Injectable({
  providedIn: 'root'
})
export class PositionService{
  private readonly API_URL = 'http://localhost:3000/positions';

  constructor(private _httpClient: HttpClient) {
  }

  getAllPosition():Observable<Position[]>{
    return this._httpClient.get<Position[]>(this.API_URL);
  }

  getPositionById(id:string): Observable<Position>{
    return this._httpClient.get<Position>(`${this.API_URL}/${id}`);
  }
}
