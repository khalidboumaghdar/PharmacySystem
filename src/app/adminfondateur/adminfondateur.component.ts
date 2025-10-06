import { Component } from '@angular/core';
import { AdminsrviceService } from '../adminsrvice.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-adminfondateur',
  templateUrl: './adminfondateur.component.html',
  styleUrls: ['./adminfondateur.component.css']
})
export class AdminfondateurComponent {

  name: string = '';
  description: string = '';
  price: number = 0;
  quantityInStock: number = 0;

  constructor(private adminService: AdminsrviceService) {}

  addProduct(): void {
    const product = {
      name: this.name,
      description: this.description,
      price: this.price,
      quantityInStock: this.quantityInStock
    };

    this.adminService.addProduct(product).subscribe({
      next: (res) => {
        console.log('✅ Product added successfully:', res);
        alert('Product added successfully!');
        this.resetForm();
      },
      error: (err: HttpErrorResponse) => {
        console.error('❌ Error adding product:', err);
        alert('Error adding product!');
      }
    });
  }

  // ♻️ إعادة تعيين الحقول بعد الإضافة
  resetForm(): void {
    this.name = '';
    this.description = '';
    this.price = 0;
    this.quantityInStock = 0;
  }
}

