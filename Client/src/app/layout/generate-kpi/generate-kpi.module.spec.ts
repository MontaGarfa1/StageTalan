import { GenerateKpiModule } from './generate-kpi.module';

describe('GenerateKpiModule', () => {
  let generateKpiModule: GenerateKpiModule;

  beforeEach(() => {
    generateKpiModule = new GenerateKpiModule();
  });

  it('should create an instance', () => {
    expect(generateKpiModule).toBeTruthy();
  });
});
