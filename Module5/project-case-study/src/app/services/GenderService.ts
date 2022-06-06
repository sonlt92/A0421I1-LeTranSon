import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Gender} from "../interface/gender";

@Injectable({
  providedIn: 'root'
})
export class GenderService {
  private readonly API_URL = "http://localhost:3000/genders";

  constructor(private _httpClient: HttpClient) {
  }

  getAllGender(): Observable<Gender[]> {
    return this._httpClient.get<Gender[]>(this.API_URL);
  }

  getGenderById(id:string): Observable<Gender>{
    return this._httpClient.get<Gender>(`${this.API_URL}/${id}`);
  }
}
