// احذف هذا السطر:
// package src;

import java.io.File;
import java.io.IOException;

public class CheckStructure {
    public static void main(String[] args) {
        System.out.println("🔍 التحقق من هيكل المشروع...");
        
        // التحقق من المجلدات الأساسية
        checkDirectory("data");
        checkDirectory("data/backups");
        checkDirectory("src");
        checkDirectory("src/models");
        checkDirectory("src/managers");
        checkDirectory("src/utils");
        checkDirectory("src/gui");
        
        System.out.println("\n📄 التحقق من الملفات...");
        // التحقق من ملف البيانات الأساسي
        checkFile("data/tasks.json");
        System.out.println("\n🎉 الهيكل الأساسي جاهز!");
    }
    
    private static void checkDirectory(String path) {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("✅ المجلد '" + path + "' موجود.");
        } else {
            System.out.println("🟡 المجلد '" + path + "' غير موجود، سيتم إنشاؤه...");
            if (dir.mkdirs()) {
                System.out.println("✅ تم إنشاء المجلد '" + path + "' بنجاح.");
            } else {
                System.out.println("❌ فشل في إنشاء المجلد '" + path + "'.");
            }
        }
    }

    private static void checkFile(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            System.out.println("✅ الملف '" + path + "' موجود.");
        } else {
            System.out.println("🟡 الملف '" + path + "' غير موجود، سيتم إنشاؤه...");
            try {
                if (file.createNewFile()) {
                    System.out.println("✅ تم إنشاء الملف '" + path + "' بنجاح.");
                } else {
                    System.out.println("❌ فشل في إنشاء الملف '" + path + "'.");
                }
            } catch (IOException e) {
                System.out.println("❌ حدث خطأ أثناء إنشاء الملف '" + path + "': " + e.getMessage());
            }
        }
    }
}