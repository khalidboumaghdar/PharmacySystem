import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminfondateurComponent } from './adminfondateur.component';

describe('AdminfondateurComponent', () => {
  let component: AdminfondateurComponent;
  let fixture: ComponentFixture<AdminfondateurComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminfondateurComponent]
    });
    fixture = TestBed.createComponent(AdminfondateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
