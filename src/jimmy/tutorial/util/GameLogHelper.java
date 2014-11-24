package jimmy.tutorial.util;

import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("static-access")
public class GameLogHelper {
	private static GameLogger gameLogger = GameLogger.log;

	public static void log(String targetLog, Level level, String message, Object... data) {
		gameLogger.log(targetLog, level, message, data);
	}

	public static void log(Level level, String message, Object... data) {
		gameLogger.log(level, message);
	}

	public static void log(String targetLog, Level level, Throwable ex, String message, Object... data) {
		gameLogger.log(targetLog, level, ex, message, data);
	}

	public static void log(Level level, Throwable ex, String message, Object... data) {
		gameLogger.log(level, ex, message, data);
	}

	public static void severe(String message) {
		log(Level.SEVERE, message);
	}

	public static void bigWarning(String format, Object... data) {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		log(Level.WARNING, "****************************************");
		log(Level.WARNING, "* " + format, data);
		for (int i = 2; i < 8 && i < trace.length; i++) {
			log(Level.WARNING, "*  at %s%s", trace[i].toString(), i == 7 ? "..." : "");
		}
		log(Level.WARNING, "****************************************");
	}

	public static void warning(String message) {
		log(Level.WARNING, message);
	}

	public static void info(String message) {
		log(Level.INFO, message);
	}

	public static Logger getLogger() {
		return gameLogger.getLogger();
	}

	/**
	 * Writes to the log text file.
	 * @param level
	 * @param text
	 */
	public static void writeToLog(Level level, String text) {
		gameLogger.writeToFile(level, text);
	}
}