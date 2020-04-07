import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyDoctorHeaderComponent } from './my-doctor-header.component';

describe('MyDoctorHeaderComponent', () => {
  let component: MyDoctorHeaderComponent;
  let fixture: ComponentFixture<MyDoctorHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyDoctorHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyDoctorHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
