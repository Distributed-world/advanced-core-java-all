package com.ps.abstractfactory2.gcp;

import com.ps.abstractfactory2.Instance;
import com.ps.abstractfactory2.Instance.Capacity;
import com.ps.abstractfactory2.ResourceFactory;
import com.ps.abstractfactory2.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new GoogleCloudStorage(capMib);
	}
	

}
