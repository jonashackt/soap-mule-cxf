package de.codecentric.soap.transformation;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import de.codecentric.namespace.weatherservice.datatypes.ProductName;
import de.codecentric.namespace.weatherservice.general.ForecastCustomer;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.soap.internalmodel.MethodOfPayment;
import de.codecentric.soap.internalmodel.Product;
import de.codecentric.soap.internalmodel.User;
import de.codecentric.soap.internalmodel.Weather;

public class GetCityForecastByZIPInMapper extends AbstractMessageTransformer {
	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		ForecastRequest forecastRequest = (ForecastRequest) message.getPayload();
		
		Weather weather = new Weather();
		weather.setPostalCode(forecastRequest.getZIP());
		weather.setFlagColor(forecastRequest.getFlagcolor());
		weather.setProduct(mapProduct(forecastRequest.getProductName()));		
		weather.setUser(mapUser(forecastRequest.getForecastCustomer()));
		return weather;
	}
	

    private static User mapUser(ForecastCustomer forecastCustomer) {
        User user = new User();
		user.setAge(forecastCustomer.getAge());
		user.setContribution(forecastCustomer.getContribution());
		user.setMethodOfPayment(mapPayment(forecastCustomer.getMethodOfPayment()));
        return user;
    }
	
	private static Product mapProduct(ProductName productName) {
        if(Product.ForecastBasic.getName().equals(productName.value())) {
            return Product.ForecastBasic;
        } else if (Product.ForecastProfessional.getName().equals(productName.value())) {
            return Product.ForecastProfessional;
        } else if (Product.ForecastUltimateXL.equals(productName.value())) {
            return Product.ForecastUltimateXL;
        } else {
            return Product.Unknown;
        }
    }

    private static MethodOfPayment mapPayment(String methodOfPayment) {
	    if(MethodOfPayment.Paypal.getName().equals(methodOfPayment)) {
	        return MethodOfPayment.Paypal;
	    } else if (MethodOfPayment.Bitcoin.getName().equals(methodOfPayment)) {
	        return MethodOfPayment.Bitcoin;
	    } else {
	        return MethodOfPayment.Unknown;
	    }
	}
}
