import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  user = {
    username: '',
    email: '',
    password: ''
  };

  constructor(private http: HttpClient, private router: Router) { }

  register() {
    this.http.post('http://localhost:8080/api/fondateurs', this.user)
      .subscribe({
        next: (res) => {
          console.log('User registered successfully', res);
          alert('Registered successfully!');
          this.router.navigate(['/login']);
        },
        error: (err) => {
          console.error('Error registering user', err);
          alert('Registration failed!');
        }
      });
  }
}
