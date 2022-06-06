import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TypeCus} from "../interface/typeCus";


@Injectable({
  providedIn: "root"
})
export class TypeCusService {
  private readonly API_URL = "http://localhost:3000/typeCus";

  constructor(private _httpClient: HttpClient) {
  }

  getAllTypeCus(): Observable<TypeCus[]> {
    return this._httpClient.get<TypeCus[]>(this.API_URL);
  }

  getTypeCusById(id: string): Observable<TypeCus> {
    return this._httpClient.get<TypeCus>(`${this.API_URL}/${id}`);
  }
}
