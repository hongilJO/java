package pattern;

public class adaptor implements adaptor_impl {

	@Override
	public Float multiply_two(Float f) {
		// TODO Auto-generated method stub
		return (float)new adaptor_math().multiply_half(f.doubleValue());
	}

	@Override
	public Float multiply_half(Float f) {
		// TODtO Auto-generated method stub
		return (float)new adaptor_math().multiply_half(f.doubleValue());
	}

}
