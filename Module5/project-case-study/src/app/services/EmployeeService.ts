import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {Observable} from "rxjs";
import {Employee} from "../interface/employee";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private readonly API_URL = 'http://localhost:3000/employees';

  constructor(private _httpClient: HttpClient) {
  }

  searchEmployee(name: string, division: number, education: number, position: number, page: number, limit: number): Observable<Employee[]> {
    let paramName = '';
    let paramDivision = '';
    let paramEducation = '';
    let paramPosition = '';
    if (name != '') {
      paramName = `fullName=${name}`;
    }
    if (division != 0) {
      paramDivision = `&division.id=${division}`
    }
    if (position != 0) {
      paramPosition = `&position.id=${position}`
    }
    if (education != 0) {
      paramEducation = `&educationDegree.id=${education}`
    }
    return this._httpClient.get<Employee[]>(`${this.API_URL}?${paramName}
    ${paramEducation}${paramDivision}${paramPosition}&_page=${page}&_limit=${limit}`);
  }


  getAllEmployee(): Observable<Employee[]> {
    return this._httpClient.get<Employee[]>(this.API_URL);
  }

  getPageEmployee(page: number, limit: number): Observable<Employee[]> {
    const url = `${this.API_URL}?_page=${page}&_limit=${limit}`;
    return this._httpClient.get<Employee[]>(url);
  }

  addNewEmployee(newEmployee: Employee): Observable<Employee> {
    return this._httpClient.post<Employee>(this.API_URL, newEmployee, httpOptions);
  }

  getEmployeeById(id: string): Observable<Employee> {
    const url = `${this.API_URL}/${id}`;
    return this._httpClient.get<Employee>(url);
  }

  updateEmployee(employee: Employee): Observable<any> {
    const url = `${this.API_URL}/${employee.id}`;
    return this._httpClient.put<any>(url, employee, httpOptions);
  }

  deleteEmployee(id: string): Observable<any> {
    const url = `${this.API_URL}/${id}`;
    return this._httpClient.delete<any>(url, httpOptions);
  }
}
