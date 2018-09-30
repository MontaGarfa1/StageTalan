import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateKpiComponent } from './generate-kpi.component';

describe('GenerateKpiComponent', () => {
  let component: GenerateKpiComponent;
  let fixture: ComponentFixture<GenerateKpiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenerateKpiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerateKpiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
