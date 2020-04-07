import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyDoctorFooterComponent } from './my-doctor-footer.component';

describe('MyDoctorFooterComponent', () => {
  let component: MyDoctorFooterComponent;
  let fixture: ComponentFixture<MyDoctorFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyDoctorFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyDoctorFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
