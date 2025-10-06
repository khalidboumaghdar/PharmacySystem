import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminsrviceService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string) {
    return this.http.post('http://localhost:8080/api/login', { username, password }, { withCredentials: true });
  }

  addProduct(product: any) {
    return this.http.post('http://localhost:8080/api/products', product, { withCredentials: true });
  }
}
