package gsu.hmi.speechauthentication.model;

public enum Language {
	Spanish {
		@Override
		public String toString() {
			return "es-ES";
		}
	} ,
	English {
		@Override
		public String toString() {
			return "en-US";
		}
	},
	French {
		@Override
		public String toString() {
			return "fr-FR";
		}
	},
	Chineese {
		@Override
		public String toString() {
			return "zh-CN";
		}
	}
}
