import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyDoctorSidenavbarComponent } from './my-doctor-sidenavbar.component';

describe('MyDoctorSidenavbarComponent', () => {
  let component: MyDoctorSidenavbarComponent;
  let fixture: ComponentFixture<MyDoctorSidenavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyDoctorSidenavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyDoctorSidenavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
