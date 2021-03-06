 translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"vn.dtt.sol.ns.kehoachdaunam.dao.NoSuchKeHoachDauNamException")) {
			return new vn.dtt.sol.ns.kehoachdaunam.dao.NoSuchKeHoachDauNamException();
		}

		return throwable;
	}

	public static Object translateOutputKeHoachDauNam(BaseModel<?> oldModel) {
		KeHoachDauNamClp newModel = new KeHoachDauNamClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setKeHoachDauNamRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   �q�Cq�,�ŗE�@}U@��)N1��~�/��$�Q�����\_baoCaoDLIService.deleteBaoCao(baoCaoDLIId);
	}

	@Override
	public vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLI updateBaoCao(
		long groupId, long baoCaoDLIId, int nam, java.lang.String maTinh,
		java.lang.String soBaoCao, java.lang.String nguoiLap,
		java.lang.String nguoiDuyet, int ngayBaoCaoMonth, int ngayBaoCaoDay,
		int ngayBaoCaoYear, long folderId, java.io.File luuTruPDF1,
		java.io.File luuTruPDF2, java.io.File luuTruCSV1,
		java.io.File luuTruCSV2, int trangThai,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _baoCaoDLIService.updateBaoCao(groupId, baoCaoDLIId, nam,
			maTinh, soBaoCao, nguoiLap, nguoiDuyet, ngayBaoCaoMonth,
			ngayBaoCaoDay, ngayBaoCaoYear, folderId, luuTruPDF1, luuTruPDF2,
			luuTruCSV1, luuTruCSV2, trangThai, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BaoCaoDLIService getWrappedBaoCaoDLIService() {
		return _baoCaoDLIService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBaoCaoDLIService(BaoCaoDLIService baoCaoDLIService) {
		_baoCaoDLIService = baoCaoDLIService;
	}

	@Override
	public BaoCaoDLIService getWrappedService() {
		return _baoCaoDLIService;
	}

	@Override
	public void setWrappedService(BaoCaoDLIService baoCaoDLIService) {
		_baoCaoDLIService = baoCaoDLIService;
	}

	private BaoCaoDLIService _baoCaoDLIService;
}