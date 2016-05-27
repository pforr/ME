/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.dtt.sol.ns.baocaodli.dao.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author HuyMQ
 * @generated
 */
public class BaoCaoDLIServiceClp implements BaoCaoDLIService {
	public BaoCaoDLIServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "initBaoCaoDLI";

		_methodParameterTypes3 = new String[] {  };

		_methodName4 = "deleteBaoCao";

		_methodParameterTypes4 = new String[] { "long" };

		_methodName5 = "updateBaoCao";

		_methodParameterTypes5 = new String[] {
				"long", "long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int", "long", "java.io.File", "java.io.File",
				"java.io.File", "java.io.File", "java.io.File", "java.io.File",
				"int", "java.lang.String", "java.util.Date", "java.lang.String",
				"java.util.Date", "com.liferay.portal.service.ServiceContext"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public void initBaoCaoDLI()
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableService.invokeMethod(_methodName3,
				_methodParameterTypes3, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void deleteBaoCao(long baoCaoDLIId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableService.invokeMethod(_methodName4,
				_methodParameterTypes4, new Object[] { baoCaoDLIId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLI updateBaoCao(
		long groupId, long baoCaoDLIId, int nam, java.lang.String maTinh,
		java.lang.String donViBaoCao, java.lang.String soBaoCao,
		java.lang.String nguoiLap, java.lang.String nguoiDuyet,
		int ngayBaoCaoMonth, int ngayBaoCaoDay, int ngayBaoCaoYear,
		long folderId, java.io.File luuTruPDF1, java.io.File luuTruPDF2,
		java.io.File luuTruPDF3, java.io.File luuTruCSV1,
		java.io.File luuTruCSV2, java.io.File luuTruCSV3, int trangThai,
		java.lang.String keHoachNam, java.util.Date ngayPheDuyet,
		java.lang.String baoCaoChuongTrinh, java.util.Date ngayDang,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						groupId,
						
					baoCaoDLIId,
						
					nam,
						
					ClpSerializer.translateInput(maTinh),
						
					ClpSerializer.translateInput(donViBaoCao),
						
					ClpSerializer.translateInput(soBaoCao),
						
					ClpSerializer.translateInput(nguoiLap),
						
					ClpSerializer.translateInput(nguoiDuyet),
						
					ngayBaoCaoMonth,
						
					ngayBaoCaoDay,
						
					ngayBaoCaoYear,
						
					folderId,
						
					ClpSerializer.translateInput(luuTruPDF1),
						
					ClpSerializer.translateInput(luuTruPDF2),
						
					ClpSerializer.translateInput(luuTruPDF3),
						
					ClpSerializer.translateInput(luuTruCSV1),
						
					ClpSerializer.translateInput(luuTruCSV2),
						
					ClpSerializer.translateInput(luuTruCSV3),
						
					trangThai,
						
					ClpSerializer.translateInput(keHoachNam),
						
					ClpSerializer.translateInput(ngayPheDuyet),
						
					ClpSerializer.translateInput(baoCaoChuongTrinh),
						
					ClpSerializer.translateInput(ngayDang),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLI)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
}