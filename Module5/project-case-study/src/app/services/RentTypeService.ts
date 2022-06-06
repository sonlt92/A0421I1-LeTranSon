import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RentType} from "../interface/rentType";

@Injectable({
  providedIn: "root"
})
export class RentTypeService {
  private readonly API_URL = "http://localhost:3000/rentTypes";

  constructor(private _httpClient: HttpClient) {
  }

  getAllRentTypes(): Observable<RentType[]> {
    return this._httpClient.get<RentType[]>(this.API_URL);
  }

  getServiceId(id:string): Observable<RentType>{
    return this._httpClient.get<RentType>(`${this.API_URL}/${id}`);
  }
}
