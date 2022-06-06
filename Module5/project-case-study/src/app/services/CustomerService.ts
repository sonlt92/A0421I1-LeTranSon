import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../interface/customer";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: "root"
})
export class CustomerService {
  private readonly API_URL = 'http://localhost:3000/customers';

  constructor(private _httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this._httpClient.get<Customer[]>(this.API_URL);
  }
  getPageCustomer(page: number, limit: number): Observable<Customer[]> {
    const url=`${this.API_URL}?_page=${page}&_limit=${limit}`;
    return this._httpClient.get<Customer[]>(url);
  }

  getCustomerByID(id: string): Observable<Customer> {
    const url = `${this.API_URL}/${id}`;
    return this._httpClient.get<Customer>(url, httpOptions);
  }

  addNewCustomer(customer: Customer): Observable<any> {
    return this._httpClient.post(this.API_URL, customer, httpOptions);
  }

  updateCustomer(customer: Customer): Observable<any> {
    const url = `${this.API_URL}/${customer.id}`;
    return this._httpClient.put(url, customer, httpOptions);
  }

  deleteCustomer(id: string): Observable<any> {
    const url = `${this.API_URL}/${id}`;
    return this._httpClient.delete(url, httpOptions);
  }
}
