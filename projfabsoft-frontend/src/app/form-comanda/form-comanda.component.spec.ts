import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormComandaComponent } from './form-comanda.component';

describe('FormComandaComponent', () => {
  let component: FormComandaComponent;
  let fixture: ComponentFixture<FormComandaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormComandaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormComandaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
