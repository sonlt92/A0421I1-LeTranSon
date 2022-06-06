import {Injectable} from "@angular/core";
import {Division} from "../interface/division";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DivisionService {
  private readonly API_URL = 'http://localhost:3000/divisions';

  constructor(private _httpClient: HttpClient) {
  }

  getAllDivision():Observable<Division[]>{
   return this._httpClient.get<Division[]>(this.API_URL);
  }

  getDivisionById(id:string): Observable<Division>{
    return this._httpClient.get<Division>(`${this.API_URL}/${id}`);
  }
}
