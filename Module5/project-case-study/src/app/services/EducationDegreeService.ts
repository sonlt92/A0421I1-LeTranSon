import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EducationDegree} from "../interface/educationDegree";

@Injectable({
  providedIn: 'root'
})
export class EducationDegreeService {
  private readonly API_URL = 'http://localhost:3000/educationDegrees';

  constructor(private _httpClient: HttpClient) {
  }

  getAllEducationDegree():Observable<EducationDegree[]>{
    return this._httpClient.get<EducationDegree[]>(this.API_URL);
  }

  getEducationDegreeById(id:string): Observable<EducationDegree>{
    return this._httpClient.get<EducationDegree>(`${this.API_URL}/${id}`);
  }
}
