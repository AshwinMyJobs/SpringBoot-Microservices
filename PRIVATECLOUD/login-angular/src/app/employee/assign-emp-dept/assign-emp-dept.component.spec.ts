import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignEmpDeptComponent } from './assign-emp-dept.component';

describe('AssignEmpDeptComponent', () => {
  let component: AssignEmpDeptComponent;
  let fixture: ComponentFixture<AssignEmpDeptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AssignEmpDeptComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AssignEmpDeptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
