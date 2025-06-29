import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRoupaComponent } from './form-roupa.component';

describe('FormRoupaComponent', () => {
  let component: FormRoupaComponent;
  let fixture: ComponentFixture<FormRoupaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormRoupaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormRoupaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
