import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyDoctorBodyComponent } from './my-doctor-body.component';

describe('MyDoctorBodyComponent', () => {
  let component: MyDoctorBodyComponent;
  let fixture: ComponentFixture<MyDoctorBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyDoctorBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyDoctorBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
