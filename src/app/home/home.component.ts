import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  products: any[] = [];
  constructor(private http: HttpClient) { }

    ngOnInit() {
      this.http.get<any[]>('http://localhost:8080/api/products')
        .subscribe(res => {
          this.products = res;
        });


}
}
